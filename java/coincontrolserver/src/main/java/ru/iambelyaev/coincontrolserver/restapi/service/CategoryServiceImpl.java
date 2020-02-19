package ru.iambelyaev.coincontolserver.restapi.service;

import org.springframework.stereotype.Service;
import ru.iambelyaev.coincontolserver.restapi.model.Category;

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

    // Хранилище клиентов
    private static final Map<Integer, Category> Category_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger Category_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Category Category) {
        final int CategoryId = Category_ID_HOLDER.incrementAndGet();
        Category.setId(CategoryId);
        Category_REPOSITORY_MAP.put(CategoryId, Category);

        String hostname = "localhost";
        int port = 5000;
        StringBuilder data = new StringBuilder();

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);

            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writeValueAsString(Category);
            System.out.println(json);
            writer.write(json);
            writer.flush();

            //int character;
//            Car car = new Car();
//            car.brand = "Rover";
//            car.doors = 5;
//            Gson gson = new Gson();
            //String json = gson.toJson(car);
//            writer.write(json);
//            writer.flush();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    @Override
    public List<Category> readAll() {

        String hostname = "localhost";
        int port = 5000;
        StringBuilder data = new StringBuilder();

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            int character;
            writer.write("/categories");
            writer.flush();
            while ((character = reader.read()) != -1) {
                data.append((char) character);
            }
        Category _category = new Category();
       _category.setName (data.toString());
        System.out.println(_category.getName());
//            writer.write("end423678");
//            writer.flush();
//            System.out.println(data);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
        return new ArrayList<>(Category_REPOSITORY_MAP.values());
    }

    @Override
    public Category read(int id) {
        return Category_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Category Category, int id) {
        if (Category_REPOSITORY_MAP.containsKey(id)) {
            Category.setId(id);
            Category_REPOSITORY_MAP.put(id, Category);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return Category_REPOSITORY_MAP.remove(id) != null;
    }
}
