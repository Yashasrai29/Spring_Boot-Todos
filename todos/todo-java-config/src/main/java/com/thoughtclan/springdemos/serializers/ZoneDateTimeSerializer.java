package com.thoughtclan.springdemos.serializers;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Json serializer implementation for {@link ZonedDateTime}.
 */
public class ZoneDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

	@Override
	public void serialize(ZonedDateTime arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		if(arg0 == null) {
			arg1.writeObject("");
		}
		arg1.writeObject(arg0.toString());
	}
}
