package test.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class KafkaListenerService {

    @Bean
    public Serde<DataModel> activitySerde() {
        return new JsonSerde(DataModel.class);
    }

    @Bean
    public Function<KStream<String, DataModel>, KStream<String, DataModel>> inputProcessor(){
        return kstream -> kstream.filter((k, v) -> v.getEquipment().equals("Tower Crane"))
                .peek((k, v) -> System.out.println(v))
                .mapValues(v -> v);
    }



}