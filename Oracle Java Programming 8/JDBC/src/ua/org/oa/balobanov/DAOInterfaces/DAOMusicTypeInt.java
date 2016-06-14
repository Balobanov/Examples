package ua.org.oa.balobanov.DAOInterfaces;

import java.util.List;
import java.util.Set;

import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.User;

public interface DAOMusicTypeInt {
	boolean insert(MusicType mt);
	List<MusicType> selectAll();
	boolean update(MusicType mt);
	MusicType selectById(int id);
	boolean delete(MusicType mt);
	Set<MusicType> selectMusicTypeForUser(int userID);
}
