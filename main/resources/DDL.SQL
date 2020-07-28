drop table if exists bookstorage.book;
create table bookstorage.book
(
	id bigserial not null,
	name varchar(255) not null,
	authors varchar(255) [] not null,
	publisher varchar(255),
	publish_year bigint,
	page_quantity bigint
);

alter table bookstorage.book owner to postgres;

create unique index if not exists book_name_authors_uindex
	on bookstorage.book (name, authors);