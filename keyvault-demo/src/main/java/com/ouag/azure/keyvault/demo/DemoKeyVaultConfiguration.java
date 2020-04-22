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
//                .clientSecret("4dbd6bdb-9e8d-4b4d-b7b0-766e9b1c0a05")
//                .clientId("f416d7a3-910d-4a38-b116-41d6ae9de20f")
//                .tenantId("5f483c8c-ae02-4ca2-a592-c959679af7ed")
//                .build();
//    }

    @Bean
    public TokenCredential getUserAssignedIMTokenCredential() {
        return  new DefaultAzureCredentialBuilder().build();
    }




}
