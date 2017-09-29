package prs.db.user;

import prs.business.User;

public interface UserReader {
	public User getUserByUserName(String inUserName);
}
