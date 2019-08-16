package de.youthclubstage.backend.blabbermouthmanagerservice.repository;

import de.youthclubstage.backend.blabbermouthmanagerservice.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@Service
public class MessageExtentedRepositoryImpl implements MessageExtentedRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<Message> findAllExample(Example<Message> example, Pageable pageable) {
        Query q = (new Query((new Criteria()).alike(example))).with(pageable);
        List<Message> list = this.mongoTemplate.find(q, example.getProbeType());
        return PageableExecutionUtils.getPage(list, pageable, () -> {
            return this.mongoTemplate.count(q, example.getProbeType());
        });
    }

    @Override
    public Page<Message> findAllByCalendarBetween(Date start, Date end, Example<Message> example, Pageable pageable) {
        Query q = (new Query((new Criteria()).alike(example).andOperator(new Criteria().and("calendar").gt(start).lt(end)))).with(pageable);
        List<Message> list = this.mongoTemplate.find(q, example.getProbeType());
        return PageableExecutionUtils.getPage(list, pageable, () -> {
            return this.mongoTemplate.count(q, example.getProbeType());
        });
    }
}
