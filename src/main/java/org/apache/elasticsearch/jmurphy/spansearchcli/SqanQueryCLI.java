/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.elasticsearch.jmurphy.spansearchcli;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.spans.SpanQuery;

/**
 *
 * @author murphy
 */
public class SqanQueryCLI {
    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("Requires two variables - field name and query");
            return;
        }
        String fieldname = args[0];
        String query = args[1];
        StringBuilder sb = new StringBuilder();
        Analyzer anal = new StandardAnalyzer((CharArraySet) null);
        SpanQueryBuilder sqb = new SpanQueryBuilder();
        SpanQuery sq = null;
        try {
            sq = sqb.getQuery(anal,"content", query, null);
        } catch (Exception e) {

            e.printStackTrace();
            return;
        }
        String tmp = QueryDiagram.diagram(sq);
        System.out.println(tmp);
        
    }
}
