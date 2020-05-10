import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class MySpiderDemo implements PageProcessor {

    // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public Site getSite() {
        return site;
    }

    // 编写爬虫流程
    public void process(Page page) {
        Html html = page.getHtml();
        //System.out.println(html);
        //List<String> test = html.xpath("//div[@class='collapse navbar-collapse']/ul/li/a/@href").all();
        List<String> test = html.xpath("//ul[@class=listing]/div/div/a/@title").all();
        for (String s : test) {
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        Spider.create(new MySpiderDemo()).addUrl("http://blog.sysake.top/archives").thread(5).run();
    }

}
