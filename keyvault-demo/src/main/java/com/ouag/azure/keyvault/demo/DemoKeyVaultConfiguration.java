package com.ouag.azure.keyvault.demo;

import com.azure.core.credential.TokenCredential;
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
            .credential(new DefaultAzureCredentialBuilder().build() )
                .buildClient();
    }

    @Bean
    public TokenCredential getTokenCredential(@Value("azure.keyvault.client-id") String clientId,
                                              @Value("azure.keyvault.client-key") String clientKey){
        return new ClientSecretCredentialBuilder()
                .clientSecret(clientKey)
                .clientId(clientId)
                .tenantId("5f483c8c-ae02-4ca2-a592-c959679af7ed")
                .build();
    }


}
