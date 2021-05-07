create table publishers
(
    publisher_id int primary key auto_increment,
    name         varchar(255) not null
);

create table loans
(
    loan_id   int primary key auto_increment,
    books     varchar(255) not null,
    user_id varchar(50) null,
);

create table books
(
    book_id        int primary key auto_increment,
    title          varchar(255) not null,
    total_pages    int          null,
    isbn           varchar(13)  null,
    published_date date         null,
    publisher_id   int          null,
    loan_id        int  null,
    foreign key (publisher_id)
        references publishers (publisher_id),
    foreign key (loan_id)
        references loans (loan_id)
);



create table authors
(
    author_id   int primary key auto_increment,
    first_name  varchar(50) not null,
    middle_name varchar(50) null,
    last_name   varchar(50) null
);

create table book_authors
(
    book_id   int not null,
    author_id int not null,

    primary key (book_id, author_id),
    constraint fk_book
        foreign key (book_id)
            references books (book_id),
    constraint fk_author
        foreign key (author_id)
            references authors (author_id)
);

create table genres
(
    genre_id int primary key auto_increment,
    genre    varchar(100) not null
);

create table book_genres
(
    book_id  int not null,
    genre_id int not null,
    primary key (book_id, genre_id),
    constraint fk_bookG
        foreign key (book_id)
            references books (book_id),
    constraint fk_genre
        foreign key (genre_id)
            references genres (genre_id)
);

create table users
(
    user_id    int primary key auto_increment,
    email      varchar(100) not null,
    password   varchar(30)  not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    city       varchar(50)  not null,
    phone      varchar(15)

);

create table roles
(
    role_id int primary key auto_increment,
    role_name    varchar(15) not null
);

create table users_roles
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint fk_user
        foreign key (user_id)
            references roles (role_id),
    constraint fk_role
        foreign key (role_id)
            references users (user_id)

);
