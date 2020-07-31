import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Person")
public class Person {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("NickName")
    private String nickname;
    @JsonProperty("Age")
    private int age;
    @JsonProperty("IdentityCode")
    private String identityCode;
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//                .registerModule(new JavaTimeModule())
//                .registerModule(new ParameterNamesModule())
//                .registerModule(new Jdk8Module());
        //导入类库之后，Jackson也可以自动搜索所有模块，不需要我们手动注册。
       mapper.findAndRegisterModules();

            Person p1 = new Person("nxx", "牛鑫鑫", 26, "10000", LocalDate.of(1994, 12, 28));
            //ObjectMapper mapper = new ObjectMapper()
                    //.registerModule(new JavaTimeModule());
            //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String text = mapper.writeValueAsString(p1);
            System.out.println(text);

            Person p2 = mapper.readValue(text, Person.class);
            System.out.println(p2);
        }
    }
