package com.example.zuo_day1;

public class movie {
	
	private int is_imax;
	private int is_new;
	private String movie_director;
	private String movie_id;
	private String movie_length;
	private String movie_message;
	private String movie_name;
	private String movie_nation;
	private String movie_picture;
	private String movie_release_date;
	private double movie_score;
	private String movie_starring;
	private String movie_tags;
	private String movie_type;
	private String movies_wd;
	
	public movie() {
	}

	public movie(int is_imax, int is_new, String movie_director, String movie_id, String movie_length,
			String movie_message, String movie_name, String movie_nation, String movie_picture,
			String movie_release_date, double movie_score, String movie_starring, String movie_tags, String movie_type,
			String movies_wd) {
		super();
		this.is_imax = is_imax;
		this.is_new = is_new;
		this.movie_director = movie_director;
		this.movie_id = movie_id;
		this.movie_length = movie_length;
		this.movie_message = movie_message;
		this.movie_name = movie_name;
		this.movie_nation = movie_nation;
		this.movie_picture = movie_picture;
		this.movie_release_date = movie_release_date;
		this.movie_score = movie_score;
		this.movie_starring = movie_starring;
		this.movie_tags = movie_tags;
		this.movie_type = movie_type;
		this.movies_wd = movies_wd;
	}

	public int getIs_imax() {
		return is_imax;
	}

	public int getIs_new() {
		return is_new;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public String getMovie_length() {
		return movie_length;
	}

	public String getMovie_message() {
		return movie_message;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public String getMovie_nation() {
		return movie_nation;
	}

	public String getMovie_picture() {
		return movie_picture;
	}

	public String getMovie_release_date() {
		return movie_release_date;
	}

	public double getMovie_score() {
		return movie_score;
	}

	public String getMovie_starring() {
		return movie_starring;
	}

	public String getMovie_tags() {
		return movie_tags;
	}

	public String getMovie_type() {
		return movie_type;
	}

	public String getMovies_wd() {
		return movies_wd;
	}

	public void setIs_imax(int is_imax) {
		this.is_imax = is_imax;
	}

	public void setIs_new(int is_new) {
		this.is_new = is_new;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public void setMovie_length(String movie_length) {
		this.movie_length = movie_length;
	}

	public void setMovie_message(String movie_message) {
		this.movie_message = movie_message;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public void setMovie_nation(String movie_nation) {
		this.movie_nation = movie_nation;
	}

	public void setMovie_picture(String movie_picture) {
		this.movie_picture = movie_picture;
	}

	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}

	public void setMovie_score(double movie_score) {
		this.movie_score = movie_score;
	}

	public void setMovie_starring(String movie_starring) {
		this.movie_starring = movie_starring;
	}

	public void setMovie_tags(String movie_tags) {
		this.movie_tags = movie_tags;
	}

	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}

	public void setMovies_wd(String movies_wd) {
		this.movies_wd = movies_wd;
	}

	@Override
	public String toString() {
		return "movie [is_imax=" + is_imax + ", is_new=" + is_new + ", movie_director=" + movie_director + ", movie_id="
				+ movie_id + ", movie_length=" + movie_length + ", movie_message=" + movie_message + ", movie_name="
				+ movie_name + ", movie_nation=" + movie_nation + ", movie_picture=" + movie_picture
				+ ", movie_release_date=" + movie_release_date + ", movie_score=" + movie_score + ", movie_starring="
				+ movie_starring + ", movie_tags=" + movie_tags + ", movie_type=" + movie_type + ", movies_wd="
				+ movies_wd + "]";
	}
	
}
