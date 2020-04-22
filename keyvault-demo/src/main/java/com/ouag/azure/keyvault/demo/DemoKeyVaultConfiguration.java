package com.ouag.azure.keyvault.demo;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DemoKeyVaultConfiguration {

    @Bean
    public SecretClient getSecretClient(TokenCredential getTokenCredential) {
        return new SecretClientBuilder()
                .vaultUrl("https://demo-keyvault-mo.vault.azure.net/")
            .credential(getTokenCredential)
                .buildClient();
    }

//    @Bean
//    public TokenCredential getTokenCredential() {
//        return new ClientSecretCredentialBuilder()
//                .clientSecret("*")
//                .clientId("*")
//                .tenantId("*")
//                .build();
//    }

    @Bean
    public TokenCredential getUserAssignedIMTokenCredential() {
        return  new DefaultAzureCredentialBuilder().build();
    }




}
