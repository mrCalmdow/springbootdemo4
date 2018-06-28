package com.flchen.demo4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author feilongchen
 * @create 2018-06-25 1:26 PM
 */
@Controller
@RequestMapping("/uploads")
public class FileUploadController {

	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

	@GetMapping
	public String redirectUploadPage() {
		return "/upload/upload";
	}

	@PostMapping("/file")
	@ResponseBody
	public Map<String, String> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
		log.info("[ContentType] - [{}]", file.getContentType());
		log.info("[fileName] - [{}]", file.getOriginalFilename());
		log.info("[fileSize] - [{}]", file.getSize());

		file.transferTo(new File("/tmp/" + file.getOriginalFilename()));
		Map<String, String> map = new HashMap<>();
		map.put("ContentType", file.getContentType());
		map.put("fileName", file.getName());
		map.put("fileSize", file.getSize() + "");
		return map;
	}

	@PostMapping("/files")
	@ResponseBody
	public List<Map<String, String>> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
		if(null == files || files.length < 1) {
			log.info("files is null");
			return null;
		}

		List<Map<String, String>> list = new ArrayList<>();
		for(MultipartFile file :  files) {
			file.transferTo(new File("/tmp/" + file.getOriginalFilename()));
			Map<String, String> map = new HashMap<>();
			map.put("ContentType", file.getContentType());
			map.put("fileName", file.getOriginalFilename());
			map.put("fileSize", file.getSize() + "");
			list.add(map);
		}

		return list;
	}

	@PostMapping("/base64")
	@ResponseBody
	public String uploadBase64(String base64) throws IOException {

		// TODO 防止有的传了 data:image/png;base64, 有的没传的情况
		String[] d = base64.split("base64,");
		final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);

		// TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
		String fileType = "";
		if(d.length > 1) {
			fileType = d[0].substring(d[0].indexOf(":") + 1,d[0].indexOf(";"));
			switch (fileType.toLowerCase()) {
				case "image/png":
					fileType = ".png";
				case "image/jpg":
				case "image/jpeg":
					fileType = ".jpg";
			}
			log.info("fileType --> [{}]", fileType);
		}
		final File tempFile = new File("/tmp/myTestFile" + fileType);
		FileCopyUtils.copy(bytes, tempFile);
		return fileType;
	}
}
