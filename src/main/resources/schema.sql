drop table if exists product;
create table product(
    product_id int not null auto_increment,
    name varchar(50) not null,
    status_id int not null,
    stock bigint not null,
    description varchar(200) not null,
    price numeric(38,2) not null,
    primary key(product_id)
);
drop table if exists status;
create table status(
    status int not null,
    status_name varchar(10) not null,
    primary key(status)
)