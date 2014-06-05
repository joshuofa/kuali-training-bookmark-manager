package edu.arizona.kuali.training.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.arizona.kuali.training.Bookmark;
import edu.arizona.kuali.training.BookmarkConstants;

public class BookmarkAction extends DispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(BookmarkConstants.FOREWARD_ADD);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public ActionForward addSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		List<Bookmark> bookmarks = (List<Bookmark>)session.getAttribute("bookmarks");
		
		String newName = request.getParameter("name");
		String newUrl = request.getParameter("url");
		
		Bookmark newBookmark = new Bookmark(newName, newUrl);
		
		bookmarks.add(newBookmark);
		session.setAttribute("bookmarks", bookmarks);
		
		return mapping.findForward(BookmarkConstants.FOREWARD_LIST);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		List<Bookmark> bookmarks = (List<Bookmark>)session.getAttribute("bookmarks");
		
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    
	    Bookmark bookmark = locateBookmarkById(bookmarks, id);
	    request.setAttribute("bookmark", bookmark);
		
		return mapping.findForward(BookmarkConstants.FOREWARD_EDIT);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public ActionForward editSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		List<Bookmark> bookmarks = (List<Bookmark>)session.getAttribute("bookmarks");
		
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    
	    Bookmark bookmark = locateBookmarkById(bookmarks, id);
	    
	    if (bookmark != null) {
	    	bookmark.setName(request.getParameter("name"));
			bookmark.setUrl(request.getParameter("url"));
	    }
		
	    return mapping.findForward(BookmarkConstants.FOREWARD_LIST);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		List<Bookmark> bookmarks = (List<Bookmark>)session.getAttribute("bookmarks");
		
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    
	    Bookmark bookmark = locateBookmarkById(bookmarks, id);
	    request.setAttribute("bookmark", bookmark);
		
		return mapping.findForward(BookmarkConstants.FOREWARD_DELETE);
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public ActionForward deleteSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		List<Bookmark> bookmarks = (List<Bookmark>)session.getAttribute("bookmarks");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		deleteBookmarkById(bookmarks, id);
		
		return mapping.findForward(BookmarkConstants.FOREWARD_LIST);
	}


	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("bookmarks") == null ) {
			List<Bookmark> bookmarks = new ArrayList<Bookmark>();
			
			bookmarks.add(new Bookmark("google", "http://google.com"));
			bookmarks.add(new Bookmark("yahoo", "http://yahoo.com"));
			session.setAttribute("bookmarks", bookmarks);
		}
		
		return mapping.findForward(BookmarkConstants.FOREWARD_LIST);
	}
	
	private Bookmark locateBookmarkById( List<Bookmark> bookmarks, Integer id) {
		
		Iterator<Bookmark> it = bookmarks.iterator();
		
		while (it.hasNext()) {
			Bookmark bookmark = it.next();
			if (id == bookmark.getId()) {
				return bookmark;
			}
		}
		
		return null;
	}
	
	private void deleteBookmarkById( List<Bookmark> bookmarks, Integer id ) {
		Iterator<Bookmark> it = bookmarks.iterator();
		
		while (it.hasNext()) {
			Bookmark bookmark = it.next();
			if (id == bookmark.getId()) {
				it.remove();
			}
		}
	}
	
}
