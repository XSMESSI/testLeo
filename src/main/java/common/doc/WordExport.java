package common.doc;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author XuShen
 * @Date 2022/10/9 10:18
 */
public class WordExport {

    @Test
    public void test() throws IOException, XDocReportException {
        generateWord();
    }

    public void generateWord() throws IOException, XDocReportException {
        //获取Word模板，模板存放路径在项目的resources目录下
        InputStream ins = this.getClass().getResourceAsStream("模板.docx");
        //注册xdocreport实例并加载FreeMarker模板引擎
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(ins,
                TemplateEngineKind.Freemarker);
        //创建xdocreport上下文对象
        IContext context = report.createContext();

        //创建要替换的文本变量
        context.put("city", "北京市");
        context.put("startDate", "2020-09-17");
        context.put("endDate", "2020-10-16");
        context.put("totCnt", 3638763);
        context.put("totAmt", "6521");
        context.put("onCnt", 2874036);
        context.put("onAmt", "4768");
        context.put("offCnt", 764727);
        context.put("offAmt", "1753");
        context.put("typeCnt", 36);

        List<Goods> goodsList = new ArrayList<Goods>();
        Goods goods1 = new Goods();
        goods1.setNum(1);
        goods1.setType("臭美毁肤");
        goods1.setSv(675512);
        goods1.setSa("589");
        Goods goods2 = new Goods();
        goods2.setNum(2);
        goods2.setType("女装");
        goods2.setSv(602145);
        goods2.setSa("651");
        Goods goods3 = new Goods();
        goods3.setNum(3);
        goods3.setType("手机");
        goods3.setSv(587737);
        goods3.setSa("866");
        Goods goods4 = new Goods();
        goods4.setNum(4);
        goods4.setType("家具家装");
        goods4.setSv(551193);
        goods4.setSa("783");
        Goods goods5 = new Goods();
        goods5.setNum(5);
        goods5.setType("食物饮品");
        goods5.setSv(528604);
        goods5.setSa("405");
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);
        goodsList.add(goods5);
        context.put("goods", goodsList);

        //创建字段元数据
        FieldsMetadata fm = report.createFieldsMetadata();
        //Word模板中的表格数据对应的集合类型
        fm.load("goods", Goods.class, true);
        //输出到本地目录
        FileOutputStream out = new FileOutputStream(new File("E:/A徐慎/测试文件导出/0209测试doc文档.doc"));
        report.process(context, out);
    }
}
