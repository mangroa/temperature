package com.mangroo.temperature;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.mangroo.temperature.business.TemperatureService;
import com.mangroo.temperature.data.Temperature;
import com.mangroo.temperature.data.repo.TemperatureRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@EnableDynamoDBRepositories(basePackages = "com.mangroo.temperature.data.repo")
public class TemperatureConfiguration {

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Value("${amazon.dynamodb.endpoint:}")
    private String amazonDynamoDBEndpoint;

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT;
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
        return new DynamoDBMapper(amazonDynamoDB, config);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        AmazonDynamoDB amazonDynamoDB;

        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB =  AmazonDynamoDBClientBuilder.standard()
                    .withCredentials(amazonAWSCredentialsProvider())
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, "AP_SOUTHEAST_2"))
                    .build();
        } else {
            amazonDynamoDB =  AmazonDynamoDBClientBuilder.standard()
                    .withCredentials(amazonAWSCredentialsProvider())
                    .withRegion(Regions.AP_SOUTHEAST_2)
                    .build();
        }
        return amazonDynamoDB;
    }

    @Bean
    public TemperatureService temperatureService(
            TemperatureRepository temperatureRepository) {
        return new TemperatureService(temperatureRepository);
    }

}
