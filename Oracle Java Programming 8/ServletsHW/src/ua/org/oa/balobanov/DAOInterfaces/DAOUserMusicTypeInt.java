package ua.org.oa.balobanov.DAOInterfaces;

import java.util.List;

public interface DAOUserMusicTypeInt {
	boolean insert(int user_id, int musicType_id);
	boolean update(int user_id_old, int musicType_id_old, int new_user_id, int new_music_id);
	boolean deleteByUser(int user_id);
	boolean deleteByMusicType(int musicType_id);
	boolean delete(int user_id, int musicType_id);
	List<Integer[]> selectByUserId(int id);
	List<Integer[]> selectByMusicId(int id);
}
