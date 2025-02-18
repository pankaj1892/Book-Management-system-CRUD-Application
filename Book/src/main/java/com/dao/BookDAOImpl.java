package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Book;
import com.utility.HibernateUtility;

public class BookDAOImpl implements BookDAO {

	@Override
	public int addBook(Book book) {
		int i = 0;

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);

			tx.commit();
			System.out.println("added success");
			i = 1;
			return i;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		} finally {
			session.close();
		}
	}

	@Override
	public int deleteBook(int bookId) {
		int i = 0;
		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book bk = (Book) session.get(Book.class, bookId);

			if (bk != null) {
				session.delete(bk);
				i = 1;
				tx.commit();

			} else {
				System.out.println("Not Existed Data In database");
				i = 0;
			}
		} catch (Exception e) {
			System.out.println("BookDAOImpl deleteBook... " + e);
		}
		return i;
	}

	@Override
	public int updateBook(Book book) {
		int i = 0;
		Transaction tx = null;

		try (Session session = HibernateUtility.getSessionFactory().openSession()) {

			Book book1 = session.get(Book.class, book.getId());
			if (book1 != null) {
				book1.setName(book.getName());
				book1.setPrice(book.getPrice());

				tx = session.beginTransaction();
				session.update(book1);
				tx.commit();

				System.out.println("Update Success...");
				i = 1;
			} else {
				System.out.println("Id Not Found");
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Book getBookById(int bookid) {

		try (SessionFactory factory = HibernateUtility.getSessionFactory(); Session session = factory.openSession()) {

			Book book = (Book) session.get(Book.class, bookid);
			if (book != null) {
				return book;

			}
			return null;

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> blist;

		SessionFactory factory = HibernateUtility.getSessionFactory();

		try (Session session = factory.openSession()) {
			Query<Book> query = session.createQuery("FROM Book", Book.class);
			blist = query.list();
			System.out.println("Books retrieved successfully.");
		} catch (Exception e) {
			System.out.println("Error fetching books: " + e.getMessage());
			throw e;
		}

		return blist;
	}

}
