INSERT INTO USERS (USER_ID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, NAME, PASSWORD, PRIMARY_EMAIL)
VALUES (1, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'Jill', '$2a$10$UQv7DHutyDHasewr4tiSgeGz2hZtc/jmJzE2UN2bctI9U9s45BQZS', 'jill@anaddress.com'),
       (2, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'Jack', '$2a$10$UQv7DHutyDHasewr4tiSgeGz2hZtc/jmJzE2UN2bctI9U9s45BQZS', 'jack@anaddress.com'),
       (3, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'Tom', '$2a$10$UQv7DHutyDHasewr4tiSgeGz2hZtc/jmJzE2UN2bctI9U9s45BQZS', 'tom@anaddress.com');

INSERT INTO ROLES (ROLE_ID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, NAME)
VALUES (1, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'ADMIN'),
       (2, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'USER'),
       (3, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP, 'DATA');


INSERT INTO USER_ROLES (ROLE_ID, USER_ID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 1, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 2, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 2, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 3, CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);

INSERT INTO MARKETS (MARKET_ID, NAME, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 'Bujumbura, Burundi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 'Gitega, Burundi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 'Ngozi, Burundi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 'Bukavu, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 'Goma, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 'Kasumbalesa, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 'Kolwezi, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 'Likasi, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 'Lubumbashi, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 'Uvira, Congo', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 'Bungoma, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (12, 'Busia, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (13, 'Eldoret, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (14, 'Embu, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (15, 'Garisa, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (16, 'Garissa, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (17, 'Isiolo, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (18, 'Kajiado, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (19, 'kakamega, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (20, 'Kisii, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (21, 'Kisumu, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (22, 'Kitale, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (23, 'Kitui, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (24, 'Loitoktok, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 'Machakos, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 'Makueni, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 'Malindi, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (28, 'Meru, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (29, 'Mombasa, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (30, 'Nairobi, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (31, 'Nakuru, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (32, 'Oloitoktok, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (33, 'Wajir, Kenya', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (34, 'Blantyre, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (35, 'Lilongwe, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (36, 'Balaka, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (37, 'Chimbiya, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (38, 'Kamwendo Market, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (39, 'Kasungu, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (40, 'Lilongwe, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (41, 'Limbe Market, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (42, 'Liwonde, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (43, 'Madisi, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (44, 'Makawa Market, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (45, 'Mchinji, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (46, 'Mitundu, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (47, 'Mkando, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (48, 'Mponela, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (49, 'Mulanje ADMARC Market, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (50, 'Mvera, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (51, 'Mwanza, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (52, 'Mzimba, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (53, 'Mzuzu, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (54, 'Namwera, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (55, 'Nkhamenya, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (56, 'Nkhotakota, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (57, 'Ntcheu, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (58, 'Ntchisi, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (59, 'Phalombe, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (60, 'Salima, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (61, 'Salima ADMARC Market, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (62, 'Thondwe, Malawi', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (63, 'Kamembe, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (64, 'Kimironko, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (65, 'Mulindi, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (66, 'Rubavu, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (67, 'Ruhengeri, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (68, 'Ruhuha, Rwanda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (69, 'Juba, South Sudan', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (70, 'Yei, South Sudan', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (71, 'Arusha, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (72, 'Babati, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (73, 'Bukoba, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (74, 'Dar es salaam, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (75, 'Dodoma, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (76, 'Geita, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (77, 'Ilala (Buguruni), Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (78, 'Iringa, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (79, 'Kibaigwa, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (80, 'Kinondoni (Tandale ), Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (81, 'lindi, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (82, 'Majengo, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (83, 'Mbeya, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (84, 'Morogoro urban, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (85, 'Moshi, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (86, 'Mtwara DC, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (87, 'Musoma, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (88, 'Mwanga, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (89, 'Mwanyelwa, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (90, 'Mwanza, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (91, 'Njombe, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (92, 'Shinyanga, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (93, 'Singida, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (94, 'Songea, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (95, 'Sumbawanga, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (96, 'Tabora, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (97, 'Tanga/Mgandini, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (98, 'Temeke, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (99, 'Tunduma, Tanzania', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (100, 'Arua, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (101, 'Bugiri Market, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (102, 'Busia, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (103, 'Gulu, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (104, 'Iganga, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (105, 'Isingiro, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (106, 'Kabale, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (107, 'Kalerwe, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (108, 'Kampala, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (109, 'KapchoRwanda, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (110, 'Kasese, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (111, 'Kiboga, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (112, 'Kisenyi, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (113, 'Lira, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (114, 'Luwero Market, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (115, 'Masaka, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (116, 'Masindi, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (117, 'Mbale, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (118, 'Mbarara, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (119, 'Mubende, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (120, 'Nakasero, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (121, 'Nakawa, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (122, 'Owino, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (123, 'Soroti, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (124, 'Tororo, Uganda', CURRENT_USER ,CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);

INSERT INTO CATEGORIES (CATEGORY_ID, NAME, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 'Animal Products', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 'Beans', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 'Cereals - Maize', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 'Cereals - Other', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 'Cereals - Rice', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 'Fruits', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 'Other', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 'Peas', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 'Roots & Tubers', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 'Seeds & Nuts', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 'Vegetables', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);

INSERT INTO SUBCATEGORIES (CATEGORY_ID, SUBCATEGORY_ID, NAME, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 1, 'Animal Products - Other', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 2, 'Livestock', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 3, 'Poultry', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 4, 'Beans', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 5, 'Maize', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 6, 'Barley', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 7, 'Millet', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 8, 'Sorghum', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 9, 'Wheat', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 10, 'Rice', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 11, 'Avocado', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 12, 'Bananas', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 13, 'Fruits', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 14, 'Lemons', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 15, 'Limes', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 16, 'Mangoes', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 17, 'Oranges', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 18, 'Pawpaw', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 19, 'Pineapples', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 20, 'Coffee', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 21, 'Cotton', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 22, 'Tea', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 23, 'Tobacco', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 24, 'Vanilla', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 25, 'Peas', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 26, 'Cassava', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 27, 'Potatoes', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 28, 'Nuts', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 29, 'Simsim', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 30, 'Sunflowers', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 31, 'Brinjals', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 32, 'Cabbages', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 33, 'Capsicums', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 34, 'Carrots', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 35, 'Cauliflower', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 36, 'Chillies', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 37, 'Cucumber', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 38, 'Ginger', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 39, 'Kales', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 40, 'Lettuce', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 41, 'Onions', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 42, 'Tomatoes', CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);

INSERT INTO PRODUCTS (SUBCATEGORY_ID, PRODUCT_ID, NAME, WHOLESALE_PRICE, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 1, 'Eggs', 348, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 2, 'Exotic Eggs', 756, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 3, 'Local Eggs', 116, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 4, 'Milk', 291, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 5, 'Nile Perch', 320, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 6, 'Processed Honey', 953, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 7, 'Tilapia', 120, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 8, 'Unprocessed Honey', 332, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 9, 'Beef', 832, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 10, 'Goat Meat', 860, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 11, 'Pork', 146, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 12, 'Exotic Chicken', 679, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 13, 'Local Chicken', 229, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 14, 'Turkey', 245, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 15, 'Agwedde Beans', 686, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 16, 'Beans', 119, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 17, 'Beans (K132)', 763, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 18, 'Beans Canadian', 390, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 19, 'Beans Mwitemania', 555, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 20, 'Beans Rosecoco', 421, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 21, 'Black Beans (Dolichos)', 399, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 22, 'Dolichos (Njahi)', 382, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 23, 'Green Gram', 343, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 24, 'Kidney Beans', 206, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 25, 'Mixed Beans', 933, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 26, 'Mwezi Moja', 984, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 27, 'Nambale Beans', 398, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 28, 'Old Beans', 622, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 29, 'Red Beans', 429, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 30, 'Soya Beans', 267, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 31, 'White Beans', 238, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (4, 32, 'Yellow Beans', 497, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 33, 'Dry Maize', 490, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 34, 'Green Maize', 237, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 35, 'Maize', 212, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 36, 'Maize Bran', 187, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (5, 37, 'Maize Flour', 964, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (6, 38, 'Barley', 590, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 39, 'Bulrush Millet', 970, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 40, 'Finger Millet', 468, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 41, 'Millet Flour', 654, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 42, 'Millet Grain', 144, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 43, 'Pearl Millet', 924, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (7, 44, 'White Millet', 742, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 45, 'Red Sorghum', 837, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 46, 'Sorghum', 549, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 47, 'Sorghum Flour', 702, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 48, 'Sorghum Grain', 142, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (8, 49, 'White Sorghum', 167, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 50, 'Wheat', 714, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 51, 'Wheat Bran', 205, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (9, 52, 'Wheat Flour', 951, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 53, 'Imported Rice', 709, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 54, 'Kahama Rice', 403, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 55, 'Kayiso Rice', 725, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 56, 'Kilombero Rice', 565, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 57, 'Mbeya Rice', 589, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 58, 'Morogoro Rice', 931, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 59, 'Paddy Rice', 184, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 60, 'Rice', 734, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 61, 'Rice Bran', 161, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 62, 'Super Rice', 889, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 63, 'Unprocessed/husked rice', 180, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (10, 64, 'Upland Rice', 471, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (11, 65, 'Avocado', 304, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (12, 66, 'Apple Bananas', 477, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (12, 67, 'Cavendish (Bogoya)', 757, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (12, 68, 'Cooking Bananas', 736, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (12, 69, 'Ripe Bananas', 620, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (13, 70, 'Passion Fruits', 703, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (14, 71, 'Lemons', 203, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (15, 72, 'Limes', 500, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (16, 73, 'Mangoes Local', 810, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (16, 74, 'Mangoes Ngowe', 501, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (17, 75, 'Oranges', 609, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (18, 76, 'Pawpaw', 112, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (19, 77, 'Pineapples', 222, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (20, 78, 'Coffee (Arabica)', 912, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (20, 79, 'Coffee (Robusta)', 827, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (21, 80, 'Unprocessed Cotton', 665, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (22, 81, 'Unprocessed Tea', 947, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (23, 82, 'Tobacco', 719, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (24, 83, 'Unprocessed Vanilla', 226, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 84, 'Chic Pea', 341, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 85, 'Cowpeas', 386, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 86, 'Dry Peas', 504, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 87, 'Fresh Peas', 164, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 88, 'Green Peas', 565, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 89, 'Peas', 672, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (25, 90, 'Pigeon Peas', 121, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 91, 'Cassava Chips', 534, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 92, 'Cassava Flour', 196, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 93, 'Cassava Fresh', 276, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 94, 'Dry Fermented Cassava', 224, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (26, 95, 'Sun Dried Cassava', 904, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 96, 'Red Irish Potatoes', 219, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 97, 'Round Potatoes', 121, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 98, 'Sweet Potatoes', 314, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 99, 'White Fleshed Sweet Potatoes', 295, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (27, 100, 'White Irish Potatoes', 195, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (28, 101, 'Ground Nuts', 328, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (28, 102, 'Groundnuts', 624, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (29, 103, 'Simsim', 612, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (30, 104, 'Sunflower Seed', 716, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (30, 105, 'Sunflower Seed Cake', 912, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (1, 106, 'Brinjal/Eggplant', 790, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (32, 107, 'Cabbages', 115, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (33, 108, 'Capsicums', 728, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (34, 109, 'Carrots', 266, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (35, 110, 'Cauliflower', 720, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (36, 111, 'Chillies', 808, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (37, 112, 'Cucumber', 892, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (38, 113, 'Ginger', 798, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (39, 114, 'Kales', 603, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (40, 115, 'Lettuce', 201, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (41, 116, 'Onions Dry', 436, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (41, 117, 'Spring Onions', 884, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (42, 118, 'Tomatoes', 166, CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);

alter sequence hibernate_sequence restart with 200;
