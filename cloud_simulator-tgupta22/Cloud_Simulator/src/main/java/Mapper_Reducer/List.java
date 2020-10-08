package Mapper_Reducer;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudsimplus.builders.tables.Table;
import org.cloudsimplus.builders.tables.TableColumn;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *  Class to get the Time in the table.
 *
 * @param <T>
 */
public class List<T> implements java.util.List<Cloudlet> {

    private static final String TIME = "%.0f";
    private static final String SECONDS = "Seconds";

    private Table table;

    @Override
    public int size() {
        return 0;
    }

    protected void createTableColumns() {

        /**
         * Below we define the method to get the start, finish and execution time.
         */
        TableColumn col = getTable(table).addColumn("StartTime", SECONDS).setFormat(TIME);

        col = getTable(table).addColumn("FinishTime", SECONDS).setFormat(TIME);

        col = getTable(table).addColumn("ExecTime", SECONDS).setFormat(TIME);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Cloudlet> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Cloudlet cloudlet) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Cloudlet> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Cloudlet> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Cloudlet get(int index) {
        return null;
    }

    @Override
    public Cloudlet set(int index, Cloudlet element) {
        return null;
    }

    @Override
    public void add(int index, Cloudlet element) {

    }

    @Override
    public Cloudlet remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Cloudlet> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Cloudlet> listIterator(int index) {
        return null;
    }

    @Override
    public java.util.List<Cloudlet> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Table getTable(Table table) {
        return table;
    }
}
