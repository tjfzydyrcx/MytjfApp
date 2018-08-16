package com.example.administrator.mytjfapp.Model;

import java.util.List;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class VideoBean {

    @Override
    public String toString() {
        return "VideoBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }

    /**
     * error : false
     * results : [{"_id":"56d791506776595ac78cd089","createdAt":"2016-03-03T09:20:16.485Z","desc":"承认问题的存在，才是解决问题的第一步","publishedAt":"2016-03-03T12:12:56.684Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/oS5LPMyRSCpXKopEfAnwcg__.htm?ep=DkrpZtGuZ%2C3757070851%2CDkrpZtGuZ%2C3757070851","used":true,"who":"lxxself"},{"_id":"577296c7421aa9387b5ae4d9","createdAt":"2016-06-28T23:24:55.494Z","desc":"哈哈哈！笑岔气了，万万没想到你是酱紫的刘备。。。全程高能，最后拜关公也是没sei了[哈哈]","publishedAt":"2016-07-01T11:06:20.244Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444b4cd761f6691bd10fc05eab03823e903","used":true,"who":"LHF"},{"_id":"56cc6d23421aa95caa707a3b","createdAt":"2015-07-21T08:19:02.839Z","desc":"尺度很大的一个视频，给你科普下房事。（不要在公司看哟","publishedAt":"2015-07-22T03:59:20.669Z","type":"休息视频","url":"http://www.bilibili.com/video/av2579180/","used":true,"who":"代码家"},{"_id":"56f33d3f67765933dbbd20cd","createdAt":"2016-03-24T09:05:03.607Z","desc":"健身吧程序猿锻炼吧程序猿！16岁小伙儿坚持锻炼一年的变化！","publishedAt":"2016-03-24T12:21:54.835Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTQ4OTMwMzk2NA==.html?from=s1.8-1-1.2","used":true,"who":"lxxself"},{"_id":"56dd941f6776592b6246e981","createdAt":"2016-03-07T22:45:51.332Z","desc":"别太任性了，别赌气对抗了；你能伤害到的的，都是最爱你的人！","publishedAt":"2016-03-09T12:06:26.401Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/23044469f903054d42da38fca343b12502d272","used":true,"who":"LHF"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }

        /**
         * _id : 56d791506776595ac78cd089
         * createdAt : 2016-03-03T09:20:16.485Z
         * desc : 承认问题的存在，才是解决问题的第一步
         * publishedAt : 2016-03-03T12:12:56.684Z
         * source : chrome
         * type : 休息视频
         * url : http://www.miaopai.com/show/oS5LPMyRSCpXKopEfAnwcg__.htm?ep=DkrpZtGuZ%2C3757070851%2CDkrpZtGuZ%2C3757070851
         * used : true
         * who : lxxself
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
