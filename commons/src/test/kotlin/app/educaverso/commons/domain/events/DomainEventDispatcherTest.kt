package app.educaverso.commons.domain.events

import app.educaverso.commons.domain.value.objects.EventId
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertEquals

class DomainEventDispatcherTest {

    @Test
    fun `should register an event handle`() {

        // Given
        val dispatcher = DomainEventDispatcher

        val eventHandler = mock<EventHandler<Event>> {
            on { eventName() } doReturn "event.created"
        }

        // When
        dispatcher.register(eventHandler)

        // Then
        assert(dispatcher.has(eventHandler))

    }

    @Test
    fun `should unregister an event handle`() {
        // Given
        val dispatcher = DomainEventDispatcher

        val eventHandler = mock<EventHandler<Event>> {
            on { eventName() } doReturn "event.created"
        }

        // When
        dispatcher.register(eventHandler)
        dispatcher.remove(eventHandler)

        // Then
        assert(!dispatcher.has(eventHandler))

    }

    @Test
    fun `should dispatch an event and notify the handler`() {
        // Given
        val dispatcher = DomainEventDispatcher

        val eventHandler = mock<EventHandler<Event>> {
            on { eventName() } doReturn "event.created"
        }

        val event = mock<Event> {
            on { name() } doReturn "event.created"
        }

        // When
        dispatcher.register(eventHandler)
        dispatcher.dispatch(event)

        // Then
        verify(eventHandler, times(1)).handle(event)

    }

    @Test
    fun `should clear all handlers`() {
        // Given
        val dispatcher = DomainEventDispatcher

        val eventHandler = mock<EventHandler<Event>> {
            on { eventName() } doReturn "event.created"
        }

        // When
        dispatcher.register(eventHandler)
        dispatcher.clear()

        // Then
        assertEquals(0, dispatcher.handlers().size)

    }

    @Test
    fun `should not register an event handle twice`() {
        // Given
        val dispatcher = DomainEventDispatcher

        val eventHandler = mock<EventHandler<Event>> {
            on { eventName() } doReturn "event.created"
        }

        // When
        dispatcher.register(eventHandler)
        dispatcher.register(eventHandler)

        // Then
        assertEquals(1, dispatcher.handlers().size)
    }

}