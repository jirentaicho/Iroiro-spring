package com.volkruss.iroiro.view;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.dataformat.csv.CsvGenerator.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class TestCsv extends AbstractView{
	
	// csvmapper
	protected final CsvMapper csvMapper = createMapper();
	
	// 出力するクラス
	protected Class<?> clazz;
	
	// 出力するデータ
	protected Collection<?> data;
	
	private CsvMapper createMapper() {
		CsvMapper mapper = new CsvMapper();
		mapper.configure(Feature.ALWAYS_QUOTE_STRINGS, true);
		mapper.findAndRegisterModules();
		return mapper;
	}
	
	// コンストラクタでクラスとデータを受取る
	public TestCsv(Class<?> clazz, Collection<?> data) {
		this.clazz = clazz;
		this.data = data;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ヘッダを設定する
		CsvSchema schema = this.csvMapper.schemaFor(clazz).withHeader();
		// TODO カラムが指定されたら指定カラムのみ出力する
		
		// csv形式で結果を取得する
		String result = csvMapper.writer(schema).writeValueAsString(data);
		System.out.println(result);
	}
}