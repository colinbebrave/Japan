package com.company;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.util.List;

public class hanlp {
    public static void main(String[] args) {
        System.out.println("首次编译运营时， HanLP会自动构建词典缓存");
        System.out.println("标准分词： ");
        System.out.println(HanLP.segment("汽水不如果汁好喝"));
        System.out.println("\n");

        //List<Term> termList = NLPTokenizer.segment("患者于1月前无明显诱因偶然发现右侧，脓肿质韧，无明显活动度");
    }
}
