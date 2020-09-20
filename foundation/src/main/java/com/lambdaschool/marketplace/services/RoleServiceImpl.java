package com.lambdaschool.marketplace.services;

import com.lambdaschool.marketplace.exceptions.ResourceFoundException;
import com.lambdaschool.marketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.marketplace.models.Role;
import com.lambdaschool.marketplace.repository.RoleRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implements the RoleService Interface
 */
@Transactional
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
  /**
   * Connects this service to the Role Model
   */
  private final RoleRepository roleRepository;

  /**
   * Connects this service to the auditing service in order to get current user name
   */
  private final UserAuditing userAuditing;

  public RoleServiceImpl(
    RoleRepository roleRepository,
    UserAuditing userAuditing
  ) {
    this.roleRepository = roleRepository;
    this.userAuditing = userAuditing;
  }

  @Override
  public Set<Role> findAll() {
    Set<Role> list = new HashSet<>();
    /*
     * findAll returns an iterator set.
     * iterate over the iterator set and add each element to an array list.
     */
    roleRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public Role findRoleById(long id) {
    return roleRepository
      .findById(id)
      .orElseThrow(
        () -> new ResourceNotFoundException("Role id " + id + " not found!")
      );
  }

  @Override
  public Role findByName(String name) {
    Role rr = roleRepository.findByNameIgnoreCase(name);

    if (rr != null) {
      return rr;
    } else {
      throw new ResourceNotFoundException(name);
    }
  }

  @Transactional
  @Override
  public Role save(Role role) {
    if (role.getUsers().size() > 0) {
      throw new ResourceFoundException(
        "User Roles are not updated through Role."
      );
    }

    return roleRepository.save(role);
  }

  @Transactional
  @Override
  public void deleteAll() {
    roleRepository.deleteAll();
  }

  @Transactional
  @Override
  public Role update(long id, Role role) {
    if (role.getName() == null) {
      throw new ResourceNotFoundException("No role name found to update!");
    }

    if (role.getUsers().size() > 0) {
      throw new ResourceFoundException(
        "User Roles are not updated through Role. See endpoint POST: users/user/{user_id}/role/{role_id}"
      );
    }

    findRoleById(id); // see if id exists

    roleRepository.updateRoleName(
      userAuditing
        .getCurrentAuditor()
        .orElseThrow(
          () ->
            new ResourceNotFoundException(
              "Serious Error: userAuditing has invalid auditor"
            )
        ),
      id,
      role.getName()
    );
    return findRoleById(id);
  }
}
