package ru.iambelyaev.coincontrolserver.restapi.service;

import org.springframework.stereotype.Service;
import ru.iambelyaev.coincontrolserver.restapi.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import java.net.*;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public void create(Category Category) {
        String hostname = "localhost";
        int port = 30001;
        StringBuilder data = new StringBuilder();
        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);

            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writeValueAsString(Category);
            System.out.println(json);
            writer.write("post");
            writer.write(json);
            writer.flush();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    @Override
    public List<Category> readAll() {
        System.out.println("+1");
        String hostname = "localhost";
        int port = 30001;
        StringBuilder data = new StringBuilder();

        ArrayList<Category> list = new ArrayList<>();
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("+2");
            OutputStream output = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            int character;
            writer.write("get");
            writer.flush();
            while ((character = reader.read()) != -1) {
                data.append((char) character);
            }
            System.out.println(data.toString());
            System.out.println("+3");

//            Category _category = new Category(1233123123,"1");

            System.out.println("+4");
            ObjectMapper objectMapper = new ObjectMapper();
//            list.add(_category);
//            System.out.println("+5");
//            list.add(_category);
//            list.add(_category);
            System.out.println(list.size());
            Category[] _category = objectMapper.readValue(data.toString(), Category[].class);
            System.out.println(_category.length);
//            for (int i = 0; i <= _category.length; i++) {
//                System.out.println(i);
//                System.out.println(_category[i].getCategoryName());
//                list.add(_category[i]);
//            }
            list.add(_category[0]);
            list.add(_category[1]);
            System.out.println("++++");
            System.out.println(list.size());
            //System.out.println(_category.getCategoryName());
//            writer.write("end423678");
//            writer.flush();
//            System.out.println(data);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
        //return new ArrayList<>(Category_REPOSITORY_MAP.values());
        return list;
    }

//    @Override
//    public Category read(int id) {
//        return Category_REPOSITORY_MAP.get(id);
//    }

//    @Override
//    public boolean update(Category Category, int id) {
//        if (Category_REPOSITORY_MAP.containsKey(id)) {
//            Category.setId(id);
//            Category_REPOSITORY_MAP.put(id, Category);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return Category_REPOSITORY_MAP.remove(id) != null;
//    }
}
