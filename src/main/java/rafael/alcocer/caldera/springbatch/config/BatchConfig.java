/**
 * Copyright [2023] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;
import rafael.alcocer.caldera.springbatch.step.Processor;
import rafael.alcocer.caldera.springbatch.step.Reader;
import rafael.alcocer.caldera.springbatch.step.Writer;

/**
 * This class replaces the XML configuration file.
 * 
 * @author Rafael Alcocer Caldera
 * @version 1.0
 *
 */
@RequiredArgsConstructor
@Configuration
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<String, String>chunk(2, transactionManager)
                .reader(new Reader())
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("job", jobRepository)
                .start(step1())
                .build();
    }
}