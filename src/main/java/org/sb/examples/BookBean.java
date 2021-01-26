package org.sb.examples;


/**
 * Represents a book
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
public class BookBean {

    // ------------------------------------------------------ Instance Variables

    /**
     * International Standard Book Number (ISBN)
     */
    private String isbn;

    /**
     * Book Title
     */
    private String title;

    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for BookBean.
     * @param title the book title
     * @param isbn the ISBN
     */
    public BookBean(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // ------------------------------------------------------ Property Accessors

    /**
     * Returns the ISBN.
     * @return the ISBN
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Returns the book title
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }


}
