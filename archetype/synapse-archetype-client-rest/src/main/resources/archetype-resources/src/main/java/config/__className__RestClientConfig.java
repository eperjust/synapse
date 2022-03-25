/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package ${package}.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import io.americanexpress.synapse.client.rest.config.BaseRestClientConfig;

import ${package}.client.${className}DeleteRestClient;
import ${package}.client.${className}GetRestClient;
import ${package}.client.${className}PostRestClient;
import ${package}.client.${className}PutRestClient;
import ${package}.handler.${className}RestResponseErrorHandler;

/**
 * {@code ${className}RestClientConfig} class sets the configurations
 * for the {@link ${className}RestClient}.
 * @author ${author}
 */
@Import(BaseRestClientConfig.class)
@PropertySource("classpath:client-application.properties")
@ComponentScan("${package}")
@Configuration
public class ${className}RestClientConfig extends BaseRestClientConfig {

	/**
	 * Used to connect to the ${apiName} REST API.
	 */
	private final ${className}GetRestClient getRestClient;
	
	/**
	 * Used to connect to the ${apiName} REST API.
	 */
	private final ${className}PostRestClient postRestClient;
	
	/**
	 * Used to connect to the ${apiName} REST API.
	 */
	private final ${className}PutRestClient putRestClient;
	
	/**
	 * Used to connect to the ${apiName} REST API.
	 */
	private final ${className}DeleteRestClient deleteRestClient;
	
	/**
	 * Used to handle errors.
	 */
	private final ${className}RestResponseErrorHandler restResponseErrorHandler;
	
	/**
	 * Argument constructor creates a new instance of ${className}RestClientConfig with given values.
	 * @param getRestClient used to connect to the ${apiName} REST API
	 * @param postRestClient used to connect to the ${apiName} REST API
	 * @param putRestClient used to connect to the ${apiName} REST API
	 * @param deleteRestClient used to connect to the ${apiName} REST API
	 * @param restResponseErrorHandler used to handle errors
	 */
	@Autowired
	public ${className}RestClientConfig(${className}GetRestClient getRestClient,
		${className}PostRestClient postRestClient,
		${className}PutRestClient putRestClient,
		${className}DeleteRestClient deleteRestClient,
		${className}RestResponseErrorHandler restResponseErrorHandler) {
		this.getRestClient = getRestClient;
		this.postRestClient = postRestClient;
		this.putRestClient = putRestClient;
		this.deleteRestClient = deleteRestClient;
		this.restResponseErrorHandler = restResponseErrorHandler;
	}
	
	/**
	 * Initialize this REST client.
	 */
	@Value("${client.url}")
	@Override
	protected void initialize(String destinationUrl) {
		initializeClient(destinationUrl, getRestClient, restResponseErrorHandler);
		initializeClient(destinationUrl, postRestClient, restResponseErrorHandler);
		initializeClient(destinationUrl, putRestClient, restResponseErrorHandler);
		initializeClient(destinationUrl, deleteRestClient, restResponseErrorHandler);
	}
}
