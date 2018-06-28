package com.flchen.demo4.entity;

import com.flchen.demo4.validation.Groups;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author feilongchen
 * @create 2018-06-25 6:36 PM
 */
@Data
public class User {

	@NotNull(message = "id can't null", groups = {Groups.Update.class})
	private Long id;

	@NotBlank(message = "username can't empty", groups = {Groups.Update.class, Groups.Default.class})
	private String username;

	@NotBlank(message = "password can't empty", groups = {Groups.Update.class, Groups.Default.class})
	private String password;

	@NotNull
	@Min(1)
	private Integer age;
}
