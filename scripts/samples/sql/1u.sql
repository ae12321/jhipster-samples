create table if not exists author (
    id bigserial,
    name character varying(255) not null,
    primary key (id)
);
insert into author (name) values ('bob'), ('mary'), ('ken');

create table if not exists author_detail (
    id bigserial,
    age integer not null,
    address character varying(255) not null,
    author_id bigint not null,
    primary key (id),
    foreign key (author_id) references author(id)
);
insert into author_detail (age, address, author_id) values (12, 'tokyo', 1), (23, 'hokkaido', 2), (34, 'okinawa', 3);

create table if not exists book (
    id bigserial,
    title character varying(255) not null,
    published_at timestamp with time zone default now(),
    author_id bigint not null,
    primary key (id),
    foreign key (author_id) references author(id)
);
insert into book (title, author_id) values ('typescript lesson', 1), ('lets programming', 2),  ('why i dont want to use java', 2);

create table if not exists tag (
    id bigserial,
    name character varying(255) not null,
    enabled boolean default true,
    primary key (id)
);
insert into tag (name) values ('own'), ('now_reading'), ('done');

create table if not exists relation_book_tag (
    book_id bigint not null,
    author_id bigint not null,
    foreign key (book_id) references book(id),
    foreign key (author_id) references author(id),
    unique (book_id, author_id)
);
insert into relation_book_tag values (1, 1), (1, 2), (2, 1), (2, 2), (2, 3), (3, 1);
