create schema ccca9;

create table ccca9.product(
    id serial primary key, 
    description varchar(100) not null, 
    price numeric not null
);

create table ccca9.voucher(
    id serial primary key,
    description varchar(25) not null,
    percentage_discount numeric not null
);

create table ccca9.order(
    id serial primary key,
    cpf varchar(11) not null,
    voucher_id integer,
    percentage_discount numeric,
    total_value numeric not null
);

create table ccca9.order_item(
    id serial primary key,
    order_id integer not null,
    product_id integer not null,
    description varchar(100) not null,
    price numeric not null,
    quantity integer not null,
    foreign key (order_id) references ccca9.order(id)
);
