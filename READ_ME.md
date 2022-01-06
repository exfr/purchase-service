Сервис Purchases
Запросы к базе:
1) Запрос на просмотр своих покупок (для пользователя) 
    Purchase getAllPurchaseByUserId(Long id);
2) Запрос всех покупок совершенными пользователями
   List<Purchase> getAllPurchase();
3) Добавление покупки для пользователя
    void addPurchase(Purchase purchase);
Сущность в БД:
   purchase:
    purchase_id PK  -- id покупки
    user_id -- id покупателя
    data_purchase - дата покупки
   purchase_product:
    product_db_id PK -- id для продукта PK для базы
    product_id -- id продукта
    name -- название продукта
    shop_id -- id шопа где был куплен товар
    price -- цена
    count -- колличество
    purchase_id_fk -- FK на purchase
Entity:
   Purchase:
    Long id;
    Long user_id;
    LocalDateTime data;
    List<Products> products;
   Product:
    Long id;
    Long product_id;
    String name;
    Long shop_id;
    BigDecimal price;
    int count;
    Purchase purchase;