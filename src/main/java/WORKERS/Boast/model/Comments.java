package WORKERS.Boast.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Comments {

	   private int commentAid;
	   private String nickname;
	   private String commentContent;
	   private Date commentDate;
	   private int aid;
}
