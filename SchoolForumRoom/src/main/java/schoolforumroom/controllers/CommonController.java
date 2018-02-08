package schoolforumroom.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestFile;
import lingshi.web.model.RequestHolder;
import net.coobird.thumbnailator.Thumbnails;
import schoolforumroom.common.Constant;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.LayUIEditImg;

@Controller
public class CommonController {

	/**
	 * layedit图片上传接口
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("LayEditImgUpload")
	public void layEditImgUpload(HttpServletRequest request, HttpServletResponse response) {
		// 由于layui中 0代表成功，所以fail和success对调
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			RequestFile requestFile = requestHolder.getRequestFile();
			if (requestFile != null && !requestFile.isEmpty()) {
				String path = Constant.ARTICLEIMG_URL + RandomNum.getLGID() + ".png";
				File file = new File(requestHolder.getRealPathPath(path));
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				Thumbnails.of(requestFile.getFile().getInputStream()).size(500, 500).outputQuality(0.7)
						.outputFormat("png").toFile(file);

				String src ="http://" + request.getServerName()+ ":" + request.getServerPort()+Constant.URLHEAD + path;
				requestHolder.fail(new LayUIEditImg(src));
				return;
			}
			requestHolder.success();
		} catch (Exception e) {
			requestHolder.success(e.getMessage());
		}
	}
}
