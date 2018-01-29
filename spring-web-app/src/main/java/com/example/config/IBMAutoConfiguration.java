package com.example.config;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.sample.SampleBean;

@Configuration
// @ConditionalOnClass(name="com.example.SomeClass")
// @ConditionalOnMissingClass(value="com.example.SomeClass")
// @ConditionalOnBean(name="hotelController")
// @ConditionalOnProperty(value = "company.name", prefix = "my")
@ConfigurationProperties(prefix = "my")
public class IBMAutoConfiguration {

	private boolean featureEnabled;

	@Range(min = 100, max = 200)
	private Integer range; // 100 - 200

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
		System.out.println("Range : " + this.range);
	}

	public boolean isFeatureEnabled() {
		return featureEnabled;
	}

	public void setFeatureEnabled(boolean featureEnabled) {
		this.featureEnabled = featureEnabled;
		System.out.println("Feature Enabled : " + this.featureEnabled);
	}

	@Bean
	public SampleBean sampleBean() {
		return new SampleBean();
	}

}
