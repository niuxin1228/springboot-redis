import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("FriendDetail")//注解用于指定JSON根属性的名称。
@JsonIgnoreProperties({"uselessProp1", "uselessProp3"})//类注解。在序列化为JSON的时候会忽略pro1和pro3两个属性
public class FriendDetail {
    @JsonProperty("NickName")//指定一个属性用于JSON映射，默认情况下映射的JSON属性与注解的属性名称相同，不过可以使用该注解的value值修改JSON属性名，该注解还有一个index属性指定生成JSON属性的顺序，如果有必要的话。
    private String name;
    @JsonProperty("Age")
    private int age;
    private String uselessProp1;
    @JsonIgnore//用于排除某个属性，这样该属性就不会被Jackson序列化和反序列化。
    private int uselessProp2;
    private String uselessProp3;

    public static void main(String[] args) throws IOException {
        //由于设置了排除的属性，所以生成的JSON和Java类并不是完全对应关系，
        //所以禁用DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES是必要的。
        ObjectMapper mapper = new ObjectMapper();
        //取消注释，启用WRAP_ROOT_VALUE功能，可以看到生成的JSON结果发生了变化，而且由于JSON结果变化，所以Java类转换失败（所有字段值全为空）
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        FriendDetail fd = new FriendDetail("nxx", 26, "", 0, "");
        String text = mapper.writeValueAsString(fd);
        System.out.println(text);

        FriendDetail fd2 = mapper.readValue(text, FriendDetail.class);
        System.out.println(fd2);
    }
}