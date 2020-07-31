import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data  //添加属性getter、setter方法代码
@AllArgsConstructor  //添加全部属性有参构造函数代码
@NoArgsConstructor  //添加无参构造函数代码

public class friend {
    private String nickname;
    private int age;

    public static void main(String[] args) throws IOException {
        //简单映射
//        ObjectMapper mapper=new ObjectMapper();
//        friend Friend=new friend("nxx",26);
//
//        // 写为字符串
//        String text = mapper.writeValueAsString(Friend);
//        // 写为文件
//        mapper.writeValue(new File("Friend.json"), Friend);
//        // 写为字节流
//        byte[] bytes = mapper.writeValueAsBytes(Friend);
//        System.out.println("JSON:"+text);
//        // 从字符串中读取
//        friend newfriend = mapper.readValue(text, friend.class);
//        // 从字节流中读取
//        newfriend = mapper.readValue(bytes, friend.class);
//        // 从文件中读取
//        newfriend = mapper.readValue(new File("Friend.json"), friend.class);
//        System.out.println("Java:"+newfriend);

        //集合的映射
        //除了使用Java类进行映射之外，我们还可以直接使用Map和List等Java集合组织JSON数据，
        // 在需要的时候可以使用readTree方法直接读取JSON中的某个属性值。
        // 需要注意的是从JSON转换为Map对象的时候，由于Java的类型擦除，
        // 所以类型需要我们手动用new TypeReference<T>给出。
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        map.put("age", 26);
        map.put("name", "nxx");
        map.put("interests", new String[]{"pc games", "music"});

        String text = mapper.writeValueAsString(map);
        System.out.println(text);

        Map<String, Object> map2 = mapper.readValue(text, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map2);

        JsonNode root = mapper.readTree(text);
        String name = root.get("name").asText();
        int age = root.get("age").asInt();

        System.out.println("name:" + name + " age:" + age);

    }




}