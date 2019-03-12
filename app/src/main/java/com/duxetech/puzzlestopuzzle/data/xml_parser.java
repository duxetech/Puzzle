package com.duxetech.puzzlestopuzzle.data;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Karthik Swamy on 13-12-2018.
 */
public class xml_parser {
    Context c;
    String title, question, answer, id, file;
    NodeList nList;
    List<Quiz> quiz;
    Quiz q;

    public NodeList xmlParse(Context context, String file){
        try{
            InputStream is =context.getAssets().open(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();
            nList = doc.getElementsByTagName("quiz");
        } catch (Exception e){
            e.printStackTrace();
        }
        return nList;
    }
    public List<Quiz> getQuiz(Context c, String file){
        List<String> titleList = new ArrayList<>();
        xmlParse(c,file);
        quiz = new ArrayList<>();
        for(int i =0;i<nList.getLength();i++){
            Node node = nList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element2 = (Element) node;
                id = element2.getElementsByTagName("id").item(0).getTextContent();
                title = element2.getElementsByTagName("title").item(0).getTextContent();
                question = element2.getElementsByTagName("question").item(0).getTextContent();
                answer = element2.getElementsByTagName("answer").item(0).getTextContent();
                titleList.add(title);
                quiz.add(new Quiz(id,title,question,answer));
            }
        }
        return quiz;

    }

    public List<Quiz> getTeaserQuiz(Context c){
        file = "data_teaser.xml";
        return getQuiz(c, file);
    }
    public List<Quiz> getLogicalQuiz(Context c){
        file = "data_logical.xml";
        return getQuiz(c, file);
    }
    public List<Quiz> getRiddlesQuiz(Context c){
        file = "data_riddles.xml";
        return getQuiz(c, file);
    }

    public String getQuestion(List<Quiz> quiz, int id){
        //getTeaserQuiz()
        return quiz.get(id).getQuestion();

    }
    public String getAnswer(List<Quiz> quiz, int id){
        return quiz.get(id).getAnswer();
    }

    public List<String> getTitle(List<Quiz> q){
        List<String> titleList = new ArrayList<>();

        for(int i=0;i<q.size();i++){
            titleList.add(q.get(i).getTitle());
        }
        return titleList;
    }
}
