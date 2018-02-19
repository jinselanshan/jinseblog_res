package com.jinse.blog.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 图片工具类
 * 
 * @author hjn
 * @version 1.0 2013-11-26
 */
public class AvatarUtil {
	/**
	 * 图片等比缩放居中剪裁 不管尺寸不等的图片生成的缩略图都是同一尺寸，方便用于页面展示
	 * 
	 * @param imageSrc图片所在路径
	 * @param thumbWidth缩略图宽度
	 * @param thumbHeight缩略图长度
	 * @param outFilePath缩略图存放路径
	 * @throws InterruptedException
	 * @throws IOException
	 */
	private static final int thumbWidth = 300;
	private static final int thumbHeight = 300;
	private static final String dir = "C://test//avatar//";

	public static String createImgThumbnail(MultipartFile avatarFile, String imgSrc)
			throws InterruptedException, IOException {
		makeDir();
		File imageFile = new File(imgSrc);
		BufferedImage image = ImageIO.read(imageFile);
		Integer width = image.getWidth();
		Integer height = image.getHeight();
		double i = (double) width / (double) height;
		double j = (double) thumbWidth / (double) thumbHeight;
		int[] d = new int[2];
		int x = 0;
		int y = 0;

		if (i > j) {
			d[1] = thumbHeight;
			d[0] = (int) (thumbHeight * i);
			y = 0;
			x = (d[0] - thumbWidth) / 2;
		} else {
			d[0] = thumbWidth;
			d[1] = (int) (thumbWidth / i);
			x = 0;
			y = (d[1] - thumbHeight) / 2;
		}
		String outFilePath = dir + "avatar" + imgSrc.substring(imgSrc.lastIndexOf('.'));
		File outFile = new File(outFilePath);
		if (!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();
		}
		/* 等比例缩放 */
		BufferedImage newImage = new BufferedImage(d[0], d[1], image.getType());
		Graphics g = newImage.getGraphics();
		g.drawImage(image, 0, 0, d[0], d[1], null);
		g.dispose();
		/* 居中剪裁 */
		newImage = newImage.getSubimage(x, y, thumbWidth, thumbHeight);
		ImageIO.write(newImage, imageFile.getName().substring(imageFile.getName().lastIndexOf(".") + 1), outFile);

		return outFilePath;
	}

	public static void makeDir() {
		File dirFile;
		boolean bFile = false;
		dirFile = new File(dir);
		bFile = dirFile.exists();
		if (bFile != true) {
			System.out.println("create a one...");
			bFile = dirFile.mkdir();
		}
	}
}