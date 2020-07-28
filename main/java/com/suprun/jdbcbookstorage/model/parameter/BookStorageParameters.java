package com.suprun.jdbcbookstorage.model.parameter;

public class BookStorageParameters {

    public static final String SORT_ORDER_ASCENDING = "asc";
    public static final String SORT_ORDER_DESCENDING = "desc";
    public static final String TAG = "tag";
    public static final String VALUE = "value";
    public static final String BOOKS = "books";

    public enum Tags{
        ID("id"), NAME("name"), AUTHORS("authors"), PUBLISHER("publisher"), PUBLISH_YEAR("publish_year"),
        PAGE_QUANTITY("page_quantity");
        private final String tag;
        Tags(String tag){
            this.tag = tag;
        }
        public String getTag() {
            return tag;
        }
    }
}
