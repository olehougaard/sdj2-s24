package dk.via.exercise6_2.viewmodel;

import dk.via.exercise6_2.model.UserModel;

public class ViewModelFactory {
    private final CreateAccountViewModel createAccountViewModel;
    private final MessageViewModel messageViewModel;
    private final GoodbyeViewModel goodbyeViewModel;

    public ViewModelFactory(UserModel model) {
        this.createAccountViewModel = new CreateAccountViewModel(model);
        this.messageViewModel = new MessageViewModel(model);
        this.goodbyeViewModel = new GoodbyeViewModel(model);
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public MessageViewModel getMessageViewModel() {
        return messageViewModel;
    }

    public GoodbyeViewModel getGoodbyeViewModel() {
        return goodbyeViewModel;
    }
}
