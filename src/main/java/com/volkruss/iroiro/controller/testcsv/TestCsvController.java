package com.volkruss.iroiro.controller.testcsv;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.volkruss.iroiro.view.TestCsv;

@Controller
public class TestCsvController {
	@GetMapping("/getcsv")
	public ModelAndView testcsv() {
		
		// csv出力対象
		List<TestData> list = List.of(
				new TestData("俺の妹がこんなに可愛いわけがない", "高坂桐乃"),
				new TestData("ラブライブ!スーパースター!!", "嵐千砂都"),
				new TestData("とある科学の超電磁砲", "御坂美琴")
			);
		
		TestCsv view = new TestCsv(TestData.class, list);
		return new ModelAndView(view);
	}	
}
