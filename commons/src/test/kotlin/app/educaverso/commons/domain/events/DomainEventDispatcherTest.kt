package app.educaverso.commons.domain.events

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

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
        assertTrue(dispatcher.has(eventHandler))

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
        assertTrue(!dispatcher.has(eventHandler))
        assertTrue(!dispatcher.handlers().containsKey(eventHandler.eventName()))
        assertTrue(dispatcher.handlers().isEmpty())
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
        assertEquals(1, dispatcher.handlers()[eventHandler.eventName()]?.size)
    }

}