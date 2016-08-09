package com.zhq.gank.mvp.news.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：hequnsky on 2016/8/4  10:37
 * 邮箱：hequnsky@gmail.com
 */
public class NewsModel implements Serializable {
    /**
     * id : 4
     * name : 贵圈真乱
     * summary : 给我一个槽点 我能撬开整个娱乐圈
     * thumbnail : http://ww1.sinaimg.cn/thumbnail/7c1bc3cfjw1evobqxr369j20dw0dw0u7.jpg
     * image : http://ww3.sinaimg.cn/large/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg
     * data : [{"document_id":28992,"display_type":2,"title":"高情商就是不让自己和别人感到尴尬！黄渤就是一本行走的情商教科书 ！","comment_count":67,"vote_count":294,"contribute":0,"timestamp":1467184797,"url":"http://mp.weixin.qq.com/s?__biz=MjM5MTMwOTU4MA==&mid=2654733187&idx=1&sn=0f21534c833fb7cb8bbcd480b4bcb1bf&scene=0#wechat_redirect","source_name":"新闻哥","hit_count":21216,"hit_count_string":"2.12万","publish_time":1467201600000,"published_at":"2016-06-29 20:00","recommenders":[{"id":683406,"name":"生活如此多焦","avatar":"http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg"}],"thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribao_recommendation_image/2016/06/1467178631743-2qp1fhy4c20nv5pm4rfhco-3c6bd07a9fe710ec303a203fcb634f6a","author_id":683406,"author_name":"生活如此多焦","author_avatar":"http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg"},{"document_id":29011,"display_type":1,"title":"周杰伦3年胖26斤笑称大家都看不出来，惨遭粉丝贴照打脸","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1467191961772-pccegwt3svr3597vwdfuo-eee10529fb2a778bc925fb0495c40716","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1467192057003-84tqhqzicw9wv1qte8ux-d84477231e589a111f12615f92fb67d7","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/29011","url":"http://dailyapi.ibaozou.com/api/v31/documents/29011","hit_count":31776,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"3.18万","timestamp":1467201620,"comment_count":128,"vote_count":289},{"document_id":28930,"display_type":1,"title":"康熙向青峰致歉：小S金曲奖喊\u201c峰姐\u201d，吴青峰粉丝这回真的不答应了","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1467102689874-eehl22v3nxs6y3h2cayzr-bc94ff3c2e8329bc105d7426f4879541","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1467102609038-49a27rvdifywy6z76hvl-4ea562beada8c77743e566342e69570a","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/28930","url":"http://dailyapi.ibaozou.com/api/v31/documents/28930","hit_count":26040,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"2.6万","timestamp":1467111618,"comment_count":89,"vote_count":164},{"document_id":28904,"display_type":2,"title":"史上最全的葛优表情包合辑，这沙发我躺定了！ ","comment_count":70,"vote_count":274,"contribute":0,"timestamp":1467082404,"url":"http://mp.weixin.qq.com/s?__biz=MzA5MjMzNTQyNw==&mid=2656026445&idx=1&sn=ac1823c26e5d4eb6ab5c902512ace5c5&scene=0#wechat_redirect","source_name":"微在Wezeit","hit_count":26475,"hit_count_string":"2.65万","publish_time":1467090000000,"published_at":"2016-06-28 13:00","recommenders":[{"id":683365,"name":"腐乳与特仑苏","avatar":"http://ww4.sinaimg.cn/large/005RXNAEjw1f0nau5c37tj305k05kmxb.jpg"}],"thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribao_recommendation_image/2016/06/1467081781276-gga52zx3wubkp6p1k6r8t-421652c7d86a479049a991f5f80e9673","author_id":683365,"author_name":"腐乳与特仑苏","author_avatar":"http://ww4.sinaimg.cn/large/005RXNAEjw1f0nau5c37tj305k05kmxb.jpg"},{"document_id":28799,"display_type":1,"title":"姜文夏雨张一山：中国演艺圈是不是每隔十几年就要出一个长这样的男孩子？ ","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466848513555-ug0p05za029szp43g1huu-768f5d8f29a56b6c21f4bb4b55333f15","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466848627807-vovrgs3vxaopxj9lm3ngp-1fbd46e0559c7af573163bf890a62026","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/28799","url":"http://dailyapi.ibaozou.com/api/v31/documents/28799","hit_count":55377,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"5.54万","timestamp":1466909558,"comment_count":222,"vote_count":503},{"document_id":28771,"display_type":1,"title":"总说我的心愿是世界和平的薛之谦原来不只是说说而已","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466761802119-rhy9dht1e58poacf2rjir-40fc06be6256d1b90f744c521bcbbac1","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466762504564-i7efecp2fmnzvm2rhpnv-b13b559ac45101c010a85d4a0f20396f","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/28771","url":"http://dailyapi.ibaozou.com/api/v31/documents/28771","hit_count":52395,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"5.24万","timestamp":1466855106,"comment_count":558,"vote_count":944},{"document_id":28746,"display_type":1,"title":"李政宰、李秀赫、赵寅成男神收割机金敏喜，她却爱上导演当小三","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466676847090-ymnfo149cblzuprrk5k8-2bb771c3014203b102f34c191c76de94","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466675762614-r97x5ylf6i1iy1kip9his-c3d9f797a588104f7aed8c3c2217c514","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/28746","url":"http://dailyapi.ibaozou.com/api/v31/documents/28746","hit_count":28383,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"2.84万","timestamp":1466772722,"comment_count":202,"vote_count":120},{"document_id":28633,"display_type":2,"title":"论陈冠希和吴亦凡的区别","comment_count":450,"vote_count":374,"contribute":0,"timestamp":1466562356,"url":"http://mp.weixin.qq.com/s?__biz=MzIzNDAxNjkxOA==&mid=2650565023&idx=1&sn=aedde170d657f262a3ab9f2668326c55&scene=1&srcid=0622MyIQSTamjptSTV1aEFEU#rd","source_name":" 槽值","hit_count":50836,"hit_count_string":"5.08万","publish_time":1466604000000,"published_at":"2016-06-22 22:00","recommenders":[{"id":683367,"name":"失足大爷翠花","avatar":"http://ww2.sinaimg.cn/large/005PbyN3jw1f0navbez6xj305l05k0sz.jpg"}],"thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribao_recommendation_image/2016/06/1466562301201-t7vm9o00omkoc9o00930z8-7b704d3a9e4e011e8e6b7363c8a2b0ce","author_id":683367,"author_name":"失足大爷翠花","author_avatar":"http://ww2.sinaimg.cn/large/005PbyN3jw1f0navbez6xj305l05k0sz.jpg"},{"document_id":28631,"display_type":2,"title":"王思聪公开说了如此多次粗口，为什么高等教育也拯救不了他的低素质？","comment_count":483,"vote_count":464,"contribute":0,"timestamp":1466562038,"url":"http://mp.weixin.qq.com/s?__biz=MzA5Mzc3NTUwNw==&mid=2653756685&idx=1&sn=62cda99f2f12b4b290bb3c20135a324f&scene=1&srcid=0622rnMAvHRAHUoS1I7q2ZU4#rd","source_name":"严肃八卦","hit_count":38099,"hit_count_string":"3.81万","publish_time":1466596800000,"published_at":"2016-06-22 20:00","recommenders":[{"id":683366,"name":"枫之流川","avatar":"http://ww3.sinaimg.cn/large/005OoMoHjw1f0nauyhjjoj305k05kglj.jpg"}],"thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribao_recommendation_image/2016/06/1466561959068-ku2f7fb8vtbutayiss42wn-57fdda9c2397e7f795dcf59b461d1527","author_id":683366,"author_name":"枫之流川","author_avatar":"http://ww3.sinaimg.cn/large/005OoMoHjw1f0nauyhjjoj305k05kglj.jpg"},{"document_id":28679,"display_type":1,"title":"Sunshine组合最新MV《我要做你女朋友》辣眼睛炸耳朵，迷之洗脑！","image":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466582512775-q01svfninega8f2beutzc-330011cd0c7f0a09e4bf82bf67553d24","thumbnail":"http://7o51ui.com2.z0.glb.qiniucdn.com/ribaopic/2016/06/1466582512765-t9sxtvwluxncwtezzwg1-330011cd0c7f0a09e4bf82bf67553d24","author_avatar":"http://ww1.sinaimg.cn/large/0060idsIjw1ewj4ffcrynj30dw0dw405.jpg","author_name":"零小蝎","author_id":272142,"section_id":125,"share_url":"http://baozouribao.com/documents/28679","url":"http://dailyapi.ibaozou.com/api/v31/documents/28679","hit_count":56406,"section_name":"贵圈真乱","section_image":"http://ww3.sinaimg.cn/small/0060u6Bxjw1ewkbig4xauj30f00a0wf5.jpg","section_color":"7CD095","hit_count_string":"5.64万","timestamp":1466593218,"comment_count":409,"vote_count":549}]
     * timestamp : 1466596800
     */

    private int id;
    private String name;
    private String summary;
    private String thumbnail;
    private String image;
    private int timestamp;
    /**
     * document_id : 28992
     * display_type : 2
     * title : 高情商就是不让自己和别人感到尴尬！黄渤就是一本行走的情商教科书 ！
     * comment_count : 67
     * vote_count : 294
     * contribute : 0
     * timestamp : 1467184797
     * url : http://mp.weixin.qq.com/s?__biz=MjM5MTMwOTU4MA==&mid=2654733187&idx=1&sn=0f21534c833fb7cb8bbcd480b4bcb1bf&scene=0#wechat_redirect
     * source_name : 新闻哥
     * hit_count : 21216
     * hit_count_string : 2.12万
     * publish_time : 1467201600000
     * published_at : 2016-06-29 20:00
     * recommenders : [{"id":683406,"name":"生活如此多焦","avatar":"http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg"}]
     * thumbnail : http://7o51ui.com2.z0.glb.qiniucdn.com/ribao_recommendation_image/2016/06/1467178631743-2qp1fhy4c20nv5pm4rfhco-3c6bd07a9fe710ec303a203fcb634f6a
     * author_id : 683406
     * author_name : 生活如此多焦
     * author_avatar : http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg
     */

    private List<DataBean> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int document_id;
        private int display_type;
        private String title;
        private int comment_count;

        private int vote_count;
        private int contribute;
        private int timestamp;

        private String share_url;


        private String url;
        private String source_name;
        private int hit_count;

        private String hit_count_string;
        private long publish_time;
        private String published_at;
        private String thumbnail;

        private int author_id;
        private String author_name;
        private String author_avatar;
        /**
         * id : 683406
         * name : 生活如此多焦
         * avatar : http://ww2.sinaimg.cn/large/005PR129jw1f0nbd4sgj6j305k05kdgc.jpg
         */

        private List<RecommendersBean> recommenders;

        public int getDocument_id() {
            return document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getContribute() {
            return contribute;
        }

        public void setContribute(int contribute) {
            this.contribute = contribute;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public int getHit_count() {
            return hit_count;
        }

        public void setHit_count(int hit_count) {
            this.hit_count = hit_count;
        }

        public String getHit_count_string() {
            return hit_count_string;
        }

        public void setHit_count_string(String hit_count_string) {
            this.hit_count_string = hit_count_string;
        }

        public long getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(long publish_time) {
            this.publish_time = publish_time;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_avatar() {
            return author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public List<RecommendersBean> getRecommenders() {
            return recommenders;
        }

        public void setRecommenders(List<RecommendersBean> recommenders) {
            this.recommenders = recommenders;
        }

        public static class RecommendersBean {
            private int id;
            private String name;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
