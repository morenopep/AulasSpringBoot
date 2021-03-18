package com.github.morenopep.clientes.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class internacionalizacaoConfig {

	
	//Define um arquivo que servira como fonte de mensagem pro sistema
	@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:messages");
			messageSource.setDefaultEncoding("ISO-8859-1");
			messageSource.setDefaultLocale(Locale.getDefault());;
			return messageSource;
		}
	
	//Objeto faz a integreção entre as mensagens e a validação
	@Bean
		public LocalValidatorFactoryBean validatorFactoryBean() {
			LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
			bean.setValidationMessageSource(messageSource());
			return bean;
	}	
	
	
	
}
