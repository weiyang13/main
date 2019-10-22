package seedu.ichifund.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.ichifund.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;

import seedu.ichifund.commons.core.GuiSettings;
import seedu.ichifund.logic.commands.exceptions.CommandException;
import seedu.ichifund.model.FundBook;
import seedu.ichifund.model.Model;
import seedu.ichifund.model.ReadOnlyFundBook;
import seedu.ichifund.model.ReadOnlyUserPrefs;
import seedu.ichifund.model.budget.Budget;
import seedu.ichifund.model.context.TransactionContext;
import seedu.ichifund.model.person.Person;
import seedu.ichifund.model.repeater.Repeater;
import seedu.ichifund.model.repeater.RepeaterUniqueId;
import seedu.ichifund.model.transaction.Transaction;
import seedu.ichifund.testutil.PersonBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Person validPerson = new PersonBuilder().build();

        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPerson), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person validPerson = new PersonBuilder().build();
        AddCommand addCommand = new AddCommand(validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getFundBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFundBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public RepeaterUniqueId getCurrentRepeaterUniqueId() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setCurrentRepeaterUniqueId(RepeaterUniqueId uniqueId) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTransaction(Transaction transaction) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTransaction(Transaction target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTransaction(Transaction target, Transaction editedTransaction) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Transaction> getFilteredTransactionList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public TransactionContext getTransactionContext() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTransactionContext(TransactionContext transactionContext) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addRepeater(Repeater repeater) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasRepeater(Repeater repeater) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteRepeater(Repeater target) {
            throw new AssertionError("This method should not be called.");
        }
        @Override
        public void setRepeater(Repeater target, Repeater editedRepeater) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Repeater> getFilteredRepeaterList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredRepeaterList(Predicate<Repeater> predicate) {
            throw new AssertionError("This method should not be called.");
        }


        @Override
        public void addBudget(Budget budget) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasBudget(Budget budget) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteBudget(Budget target) {
            throw new AssertionError("This method should not be called.");
        }
        @Override
        public void setBudget(Budget target, Budget editedBudget) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Budget> getFilteredBudgetList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredBudgetList(Predicate<Budget> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyProperty<TransactionContext> getTransactionContextProperty() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFundBook(ReadOnlyFundBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyFundBook getFundBook() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Person person;

        ModelStubWithPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return this.person.isSamePerson(person);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Person> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return personsAdded.stream().anyMatch(person::isSamePerson);
        }

        @Override
        public void addPerson(Person person) {
            requireNonNull(person);
            personsAdded.add(person);
        }

        @Override
        public ReadOnlyFundBook getFundBook() {
            return new FundBook();
        }
    }

}
