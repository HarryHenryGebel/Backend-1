INSERT INTO ITEMS (ITEM_ID, NAME, DESCRIPTION ,PRICE, MARKET_ID,
                   PRODUCT_ID, USER_ID,
                   CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE)
VALUES (1, 'Egg Sale!', 'Eggs for 200 Shillings per unit', 400, 1,
        1, 1,
        CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (2, 'Best Milk!', 'Fresh milk only!', 350, 2,
        4, 2,
        CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP),
       (3, 'Delicious Honey!', 'Our happy bees make happy honey!', 1100, 3,
        6, 3,
        CURRENT_USER, CURRENT_TIMESTAMP, CURRENT_USER, CURRENT_TIMESTAMP);
