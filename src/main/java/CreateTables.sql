Hibernate: 
    
    create table coupan (
       coupan_id number(10,0) not null,
        coupan_description varchar2(255),
        coupan_name varchar2(255),
        coupan_type varchar2(255),
        primary key (coupan_id)
    )
Hibernate: 
    
    create table order_map_pizza_quantity (
       order_id number(10,0) not null,
        map_pizza_quantity number(10,0),
        map_pizza_quantity_key number(10,0) not null,
        primary key (order_id, map_pizza_quantity_key)
    )

Hibernate: 
    
    create table pizza (
       id number(10,0) not null,
        description varchar2(255),
        name varchar2(255),
        type varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table pizza_cost (
       cost_id number(10,0) not null,
        cost double precision not null,
        pizza_size varchar2(255),
        pizza_id number(10,0),
        primary key (cost_id)
    )
Hibernate: 
    
    create table pizza_customer (
       customer_id number(10,0) not null,
        customer_address varchar2(255),
        customer_email varchar2(255),
        customer_mobile number(19,0),
        customer_name varchar2(255),
        password varchar2(255),
        user_name varchar2(255),
        primary key (customer_id)
    )

Hibernate:    
    alter table pizza_cost 
       add constraint FKdi86g4mu9vtb5c1qdprtcc2pi 
       foreign key (pizza_id) 
       references pizza
       
       
Hibernate: 
    
    create table order_cart (
       order_id number(10,0) not null,
        cart number(10,0),
        cart_key number(10,0) not null,
        primary key (order_id, cart_key)
    )
Hibernate: 
    
    create table ordering (
       id number(10,0) not null,
        description varchar2(255),
        total_cost double precision not null,
        transaction_mode varchar2(255),
        type varchar2(255),
        coupan_coupan_id number(10,0),
        customer_customer_id number(10,0),
        primary key (id)
    )
Hibernate: 
    
    alter table order_cart 
       add constraint FKe2j5kycl0xrwxkr9xesjgnpmk 
       foreign key (order_id) 
       references ordering
Hibernate: 
    
    alter table ordering 
       add constraint FKtm055t9egg8h1uetfgemi7aj5 
       foreign key (coupan_coupan_id) 
       references coupan
Hibernate: 
    
    alter table ordering 
       add constraint FKika1ehf8jpcajxub4byo0hfd7 
       foreign key (customer_customer_id) 
       references pizza_customer
    
       
 -----------------24-03-2021-------------
 Hibernate: 
    
    create table coupan (
       id number(10,0) not null,
        description varchar2(255),
        name varchar2(255),
        price_discount number(10,0) not null,
        type varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table order_cart (
       order_id number(10,0) not null,
        cart number(10,0),
        cart_key number(10,0) not null,
        primary key (order_id, cart_key)
    )
Hibernate: 
    
    create table pizza (
       id number(10,0) not null,
        description varchar2(255),
        name varchar2(255),
        type varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table pizza_cost (
       cost_id number(10,0) not null,
        cost double precision not null,
        pizza_size varchar2(255) not null,
        pizza_id number(10,0),
        primary key (cost_id)
    )
Hibernate: 
    
    create table pizza_order (
       id number(10,0) not null,
        description varchar2(255),
        total_cost double precision not null,
        transaction_mode varchar2(255),
        type varchar2(255),
        coupan_id number(10,0),
        customer_id number(10,0),
        primary key (id)
    )
Hibernate: 
    
    create table users (
       dtype varchar2(31) not null,
        id number(10,0) not null,
        mobile_number varchar2(255) not null,
        password varchar2(255) not null,
        role varchar2(255) not null,
        address varchar2(255),
        email varchar2(255),
        name varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    alter table users 
       drop constraint UK_r7c96a004bv8w16jgdm8imich
Hibernate: 
    
    alter table users 
       add constraint UK_r7c96a004bv8w16jgdm8imich unique (mobile_number)
Hibernate: 
    
    alter table order_cart 
       add constraint FKm4aggn98gb50t97cuq6uamisc 
       foreign key (order_id) 
       references pizza_order
Hibernate: 
    
    alter table pizza_cost 
       add constraint FKdi86g4mu9vtb5c1qdprtcc2pi 
       foreign key (pizza_id) 
       references pizza
Hibernate: 
    
    alter table pizza_order 
       add constraint FKe53d7posgpsp41m3s4dka3up3 
       foreign key (coupan_id) 
       references coupan
Hibernate: 
    
    alter table pizza_order 
       add constraint FKmyux7i90upn8gob1jagasurj4 
       foreign key (customer_id) 
       references users

       
 create table coupan (
       id number(10,0) not null,
        description varchar2(255),
        name varchar2(255),
        type varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table order_cart (
       order_id number(10,0) not null,
        cart number(10,0),
        cart_key number(10,0) not null,
        primary key (order_id, cart_key)
    )
Hibernate: 
    
    create table pizza (
       id number(10,0) not null,
        description varchar2(255),
        name varchar2(255),
        type varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table pizza_cost (
       cost_id number(10,0) not null,
        cost double precision not null,
        pizza_size varchar2(255),
        pizza_id number(10,0),
        primary key (cost_id)
    )
Hibernate: 
    
    create table pizza_customer (
       id number(10,0) not null,
        customer_address varchar2(255),
        customer_email varchar2(255),
        mobile number(19,0),
        name varchar2(255),
        password varchar2(255),
        user_name varchar2(255),
        primary key (id)
    )
Hibernate: 
    
    create table pizza_customer_orders (
       customer_id number(10,0) not null,
        orders_id number(10,0) not null
    )
Hibernate: 
    
    create table pizza_order (
       id number(10,0) not null,
        description varchar2(255),
        total_cost double precision not null,
        transaction_mode varchar2(255),
        type varchar2(255),
        coupan_id number(10,0),
        customer_id number(10,0),
        primary key (id)
    )
Hibernate: 
    
    alter table pizza_customer_orders 
       drop constraint UK_cbhnmgcuxpbmjhy6ugwushjhc
Hibernate: 
    
    alter table pizza_customer_orders 
       add constraint UK_cbhnmgcuxpbmjhy6ugwushjhc unique (orders_id)
Hibernate: 
    
    alter table order_cart 
       add constraint FKm4aggn98gb50t97cuq6uamisc 
       foreign key (order_id) 
       references pizza_order
Hibernate: 
    
    alter table pizza_cost 
       add constraint FKdi86g4mu9vtb5c1qdprtcc2pi 
       foreign key (pizza_id) 
       references pizza
Hibernate: 
    
    alter table pizza_customer_orders 
       add constraint FK4cjtp6a3cd5rx8kwdcigw6bhs 
       foreign key (orders_id) 
       references pizza_order
Hibernate: 
    
    alter table pizza_customer_orders 
       add constraint FK2wi4e37ncfp44trfpijfix7ae 
       foreign key (customer_id) 
       references pizza_customer
Hibernate: 
    
    alter table pizza_order 
       add constraint FKe53d7posgpsp41m3s4dka3up3 
       foreign key (coupan_id) 
       references coupan
Hibernate: 
    
    alter table pizza_order 
       add constraint FKjrqoq3fq6ilpo2ctk7e0l60va 
       foreign key (customer_id) 
       references pizza_customer

