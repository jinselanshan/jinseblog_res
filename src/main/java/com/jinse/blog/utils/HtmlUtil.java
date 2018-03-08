package com.jinse.blog.utils;

public class HtmlUtil {
/*	public static void main(String[] args) {
		String s = "<div>  热度(113)</div>;";
		s = getContent(s, 50, true);
		System.out.println(s);
	}*/

	public static String getContent(String content, int length, boolean StripHTML) {
		if (content == null || length == 0)
			return "";
		if (StripHTML) {
			content = content.replaceAll("</?[^>]+>", ""); // 剔出<html>的标签
			content = content.replaceAll("<a>\\s*|\t|\r|\n</a>", "");// 去除字符串中的空格,回车,换行符,制表符
			content = content.replace("　", "　").replace(" ", "　");
			if (content.length() <= length)
				return content;
			else
				return content.substring(0, length) + "……";
		} else {
			if (content.length() <= length)
				return content;

			int pos = 0, npos = 0, size = 0;
			boolean firststop = false, notr = false, noli = false;
			StringBuilder sb = new StringBuilder();
			while (true) {
				if (pos >= content.length())
					break;
				String cur = content.substring(pos, 1);
				if (cur == "<") {
					String next = content.substring(pos + 1, 3).toLowerCase();
					if (next.indexOf("p") == 0 && next.indexOf("pre") != 0) {
						npos = content.indexOf(">", pos) + 1;
					} else if (next.indexOf("/p") == 0 && next.indexOf("/pr") != 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length)
							sb.append("<br/>");
					} else if (next.indexOf("br") == 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length)
							sb.append("<br/>");
					} else if (next.indexOf("img") == 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length) {
							sb.append(content.substring(pos, npos - pos));
							size += npos - pos + 1;
						}
					} else if (next.indexOf("li") == 0 || next.indexOf("/li") == 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length) {
							sb.append(content.substring(pos, npos - pos));
						} else {
							if (!noli && next.indexOf("/li") == 0) {
								sb.append(content.substring(pos, npos - pos));
								noli = true;
							}
						}
					} else if (next.indexOf("tr") == 0 || next.indexOf("/tr") == 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length) {
							sb.append(content.substring(pos, npos - pos));
						} else {
							if (!notr && next.indexOf("/tr") == 0) {
								sb.append(content.substring(pos, npos - pos));
								notr = true;
							}
						}
					} else if (next.indexOf("td") == 0 || next.indexOf("/td") == 0) {
						npos = content.indexOf(">", pos) + 1;
						if (size < length) {
							sb.append(content.substring(pos, npos - pos));
						} else {
							if (!notr) {
								sb.append(content.substring(pos, npos - pos));
							}
						}
					} else {
						npos = content.indexOf(">", pos) + 1;
						sb.append(content.substring(pos, npos - pos));
					}
					if (npos <= pos)
						npos = pos + 1;
					pos = npos;
				} else {
					if (size < length) {
						sb.append(cur);
						size++;
					} else {
						if (!firststop) {
							sb.append("……");
							firststop = true;
						}
					}
					pos++;
				}

			}
			return sb.toString();
		}
	}
}
