/**
 * Create by: User - CMC
 * Create date: Feb 22, 2019
 * Modifier: User
 * Modified date: Feb 22, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 22, 2019
 * Modifier: thanhtd
 * Modified date: Feb 22, 2019
 * Description: ....
 * Version 1.0
 */
public interface UploadFileService {
	public String saveFile(MultipartFile file);
	Resource findFileByName(String nameFile);
	public String saveFileVer(MultipartFile file, String pathToSave);
}
